package com.revature.servlets.getters;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetProfileServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int userpassid = Integer.parseInt(request.getParameter("userpassid"));
    UserPass up = new UserPassService().getById(userpassid);
    response.setContentType("text/json");
    PrintWriter writer = response.getWriter();
    String json = "";
    if (up != null) {
      switch (up.getRole()) {
        case "user":
          UserAccount user = new UserService().getByUserPass(userpassid);
          if (user != null) {
            json = ObjectToJSONService.UserAccountToJSON(user);
          }
          break;
        case "patient":
          Patient patient = new PatientService().getByUserPass(userpassid);
          if (patient != null) {
            json = ObjectToJSONService.PatientToJSON(patient);
          }
          break;
        case "nurse":
          Nurse nurse = new NurseService().getByUserPass(userpassid);
          if (nurse != null) {
            json = ObjectToJSONService.NurseToJSON(nurse);
          }
          break;
        case "doctor":
          Doctor doctor = new DoctorService().getByUserPass(userpassid);
          if (doctor != null) {
            json = ObjectToJSONService.DoctorToJSON(doctor);
          }
          break;
      }
    }
    writer.println(json);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
