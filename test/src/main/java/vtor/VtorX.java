package vtor;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VtorX {

    List<ItemCheck> checks ;


    public List<ItemCheck> getChecks() {
        return checks;
    }

    public void setChecks(List<ItemCheck> checks) {
        this.checks = checks;
    }


    public List<Result> validate(ValidateContext context, Object target) throws Exception {
        List<Result> results = new ArrayList<>();
        for(Map.Entry<String, List<ItemCheck>> entry : context.map.entrySet()){
            String name = entry.getKey();
            List<ItemCheck> checks = entry.getValue();
            PropertyDescriptor descriptor = new PropertyDescriptor(name, target.getClass());
            Object value = descriptor.getReadMethod().invoke(target, null);

            for(ItemCheck check : checks){
                ValidateContraingContextX contraingContextX = new ValidateContraingContextX(this, name, target);
                boolean flag = check.getValidateConstraint().valid(contraingContextX, value);
                if(!flag){
                    results.add(new Result());
                }
            }

        }
        return results;

    }
}
