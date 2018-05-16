package scan.proccssor;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/28.
 */
public class Scanner extends ClassPathBeanDefinitionScanner {

    public MyFactoryBean factoryBean = new MyFactoryBean<Object>();


    public MyFactoryBean getFactoryBean() {
        return factoryBean;
    }


    public void setMapperFactoryBean(MyFactoryBean<?> factoryBean) {
        this.factoryBean = factoryBean != null ? factoryBean : new MyFactoryBean<Object>();
    }

    public Scanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    public void registerDefaultFilters() {
//        this.addIncludeFilter(new AnnotationTypeFilter(CustomizeComponent.class));
        this.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws
                    IOException {
                return true;
            }
        });

    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {

        Set<BeanDefinitionHolder> set = super.doScan("scan.what");

        for(BeanDefinitionHolder holder : set){
            BeanDefinition d = holder.getBeanDefinition();

            GenericBeanDefinition definition = (GenericBeanDefinition)d;

            definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName());
            definition.setBeanClassName(factoryBean.getClass().getName());

//            definition.getPropertyValues().add("addToConfig", true);


        }

        return set;
    }

    @Override
    protected boolean isCompatible(BeanDefinition newDefinition, BeanDefinition existingDefinition) {
        return super.isCompatible(newDefinition, existingDefinition);
    }


    @Override
    protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
        return super.isCandidateComponent(metadataReader);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }
}
