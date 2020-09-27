package com.melalex.hts.resolver;

import com.melalex.hts.annotation.HtsField;
import com.melalex.hts.annotation.HtsMessage;
import com.melalex.hts.model.MessageDescriptor;

import javax.annotation.processing.RoundEnvironment;
import javax.swing.text.Element;
import java.util.stream.Collectors;

public class MessageDescriptorResolver {

    private final FieldDescriptorResolver fieldDescriptorResolver;

    public MessageDescriptorResolver(FieldDescriptorResolver fieldDescriptorResolver) {
        this.fieldDescriptorResolver = fieldDescriptorResolver;
    }

    public MessageDescriptor resolve(HtsMessage htsMessageAnnotation, RoundEnvironment roundEnvironment) {
        return new MessageDescriptor(
                htsMessageAnnotation.key(),
                htsMessageAnnotation.type(),
                htsMessageAnnotation.delimiter().getValue(),
                roundEnvironment.getElementsAnnotatedWith(HtsField.class)
                        .stream()
                        .map(e -> fieldDescriptorResolver.resolve((Element) e))
                        .collect(Collectors.toList())
        );
    }
}
