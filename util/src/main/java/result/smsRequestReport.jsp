customerInfoDataGrid.datagrid({
            url: '',
            fit: false,
            fitColumns: true,
            border: false,
            pagination: true,
            pageSize: 30,//每页显示的记录条数，默认为10
            pageList: [10, 20, 30, 50, 100],//可以设置每页记录条数的列表
            idField: 'sid',
            sortName: 'sid',
            sortOrder: 'asc',
            checkOnSelect: true,
            selectOnCheck: true,
            nowrap: false,
            singleSelect: false,
            toolbar: '#customerInfoBar',
            columns: [[
                                {title: '邮箱', field: '邮箱', width: 20},
                {title: '认证名称', field: '认证名称', width: 20},
                {title: '提交失败总数', field: '提交失败总数', width: 20},
                {title: '提交成功总数', field: '提交成功总数', width: 20},
                {title: '发送成功数量', field: '发送成功数量', width: 20},
                {title: '手机号码', field: '手机号码', width: 20},
                {title: '发送失败率', field: '发送失败率', width: 20},
                {title: '提交失败率', field: '提交失败率', width: 20},
                {title: '发送成功率', field: '发送成功率', width: 20},
                {title: '提交总数', field: '提交总数', width: 20},
        });

        var p = customerInfoDataGrid.datagrid('getPager');
        $(p).pagination({
            beforePageText: '第',
            afterPageText: '页    共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        });

    })

    //清空列表
    function clearSelectDataGrid() {
        customerInfoDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
    }

    function research() {
        rechargeCustomerInfoDataGrid.datagrid('getPager').pagination({pageNumber:1});
        var params = rechargeCustomerInfoDataGrid.datagrid('options').queryParams;

        var source = $("#source").val();
        var beginDate = $("#beginDate").datebox('getValue');
        var endDate = $("#endDate").datebox('getValue');

        if (source != undefined ) {
            params["source"] = source;
        }

        if (beginDate != undefined ) {
            params["beginDate"] = beginDate;
        }

        if (endDate != undefined ) {
            params["endDate"] = endDate;
        }

        rechargeCustomerInfoDataGrid.datagrid('options').queryParams = params;
        rechargeCustomerInfoDataGrid.datagrid('reload');
    }


    //导出充值记录
    function exportExcel(){
        $("#searchCustomerInfoForm").submit();
    }