package com.deliverycompany.api.mapper;

import com.deliverycompany.api.model.Occurrences;
import com.deliverycompany.api.model.OccurrenceResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceResponse toModel(Occurrences occurrences) {
        return modelMapper.map(occurrences, OccurrenceResponse.class);
    }

    public List<OccurrenceResponse> toCollectionModel(List<Occurrences> occurrences) {
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
