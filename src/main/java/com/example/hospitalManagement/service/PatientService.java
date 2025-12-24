package com.example.hospitalManagement.service;

import com.example.hospitalManagement.dto.PatientResponseDto;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private  final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

//    @Transactional
//    public Patient getPatientById(Long id){
//        Patient p1 = patientRepository.findById(id).orElseThrow();
//        Patient p2 = patientRepository.findById(id).orElseThrow();
//        System.out.println(p1==p2);
//        p1.setName("yoyo");
////        patientRepository.save(p1); //as due to Transactional query it get autoupdated without patientRepository.save(p1)
//        return p1;
//    }

@Transactional
public PatientResponseDto getPatientById(Long patientId) {
    Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not " +
            "Found with id: " + patientId));
    return modelMapper.map(patient, PatientResponseDto.class);
}


    public List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize) {
        return patientRepository.findAllPatients(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
                .collect(Collectors.toList());
    }

}
