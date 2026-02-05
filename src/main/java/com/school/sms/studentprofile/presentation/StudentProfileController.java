package com.school.sms.studentprofile.presentation;


import com.school.sms.studentprofile.application.usecase.GetStudentProfileUseCase;
import com.school.sms.studentmanagement.domain.model.Student;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class StudentProfileController {

    private final GetStudentProfileUseCase getProfile;

    public StudentProfileController(GetStudentProfileUseCase getProfile) {
        this.getProfile = getProfile;
    }

    /**
     * Student can view only their own profile.
     * JWT filter will ensure identity.
     */
    @GetMapping("/{studentId}")
    public Student getProfile(@PathVariable String studentId) {
        return getProfile.execute(studentId);
    }
}
