package com.efeak.MiniProject.mapper;

import com.efeak.MiniProject.dto.request.CreateStudentRequestDto;
import com.efeak.MiniProject.repository.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IStudentMapper {
    IStudentMapper INSTANCE = Mappers.getMapper(IStudentMapper.class);
    Student toStudent(final CreateStudentRequestDto dto);
}
