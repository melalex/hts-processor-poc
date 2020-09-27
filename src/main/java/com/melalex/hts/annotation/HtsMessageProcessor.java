package com.melalex.hts.annotation;


import com.melalex.hts.resolver.FieldDescriptorResolver;
import com.melalex.hts.resolver.MessageDescriptorResolver;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("com.melalex.hts.annotation.HtsMessage")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HtsMessageProcessor extends AbstractProcessor {

    private final FieldDescriptorResolver fieldDescriptorResolver = new FieldDescriptorResolver();
    private final MessageDescriptorResolver messageDescriptorResolver = new MessageDescriptorResolver(fieldDescriptorResolver);

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        System.out.println("HtsMessageProcessor: " + annotations + ", " + roundEnvironment);

        roundEnvironment.getElementsAnnotatedWith(HtsMessage.class).stream()
                .map(a -> a.getAnnotation(HtsMessage.class))
                .map(a -> messageDescriptorResolver.resolve(a, roundEnvironment))
                .forEach(System.out::println);

        return true;
    }
}
