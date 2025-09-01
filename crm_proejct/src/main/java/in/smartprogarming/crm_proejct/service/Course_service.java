package in.smartprogarming.crm_proejct.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.smartprogarming.crm_proejct.User.Course;
import in.smartprogarming.crm_proejct.repository.couse_Repository;


@Service
public class Course_service{
    
    @Autowired
 private  couse_Repository couse_Repository;

    public  List<Course>  getallcourse()
    {
        List<Course> courseList = couse_Repository.findAll();
        return courseList;
    }
public void addCourse(Course course, MultipartFile courseImg) throws IOException {
    // Absolute folder path
    String uploadDir = "C:/Users/user/Desktop/hidden/crm_proejct/src/main/resources/static/uplode";
    String baseUrl = "http://localhost:8080/uplode/";

    // Create folder if it doesn't exist
    java.nio.file.Path uploadPath = java.nio.file.Paths.get(uploadDir);
    if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
    }

    // Save the file
    String imageName = courseImg.getOriginalFilename();
    java.nio.file.Path filePath = uploadPath.resolve(imageName); // automatically adds the "/" between folder & filename
    Files.write(filePath, courseImg.getBytes());

    // Set URL for access
    course.setImage_url(baseUrl + imageName);

    // Save course in DB
    couse_Repository.save(course);
}



}
