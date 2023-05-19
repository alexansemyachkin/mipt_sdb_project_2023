package ru.mipt.rea.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Convertor {

    private final ModelMapper modelMapper;

    public Convertor() {
        this.modelMapper = new ModelMapper();
        Configuration configuration = modelMapper.getConfiguration();

        configuration.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        configuration.setMatchingStrategy(MatchingStrategies.STANDARD);

        configuration.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR);
        configuration.setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

        configuration.setSourceNameTokenizer(NameTokenizers.CAMEL_CASE);
        configuration.setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
    }

    public <SourceType, DestinationType> DestinationType convert(SourceType sourceObject,
                                                                 Class<DestinationType> destinationType){
        return modelMapper.map(sourceObject, destinationType);
    }

    public <SourceType, DestinationType> List<DestinationType> convertList(List<SourceType> sourceList,
                                                                           Class<DestinationType> destinationType) {
        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .collect(Collectors.toList());
    }

}
