package com.revature.servlets.getters;

import com.revature.beans.Admin;
import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.services.AdminService;
import com.revature.services.ObjectToJSONService;
import com.revature.services.PatientService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.revature.services.ObjectToJSONService.*;

public class GetProfileServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    UserPass up = new UserPassService().getByUsername(username);
    response.setContentType("text/json");
    PrintWriter writer = response.getWriter();
    String json = "";
    if (up != null) {
      switch (up.getRole()) {
        case "user":
          UserAccount user = new UserService().getByUserPass(up.getId());
          if (user != null) {
            json = allAccountsToJSON(Arrays.asList(user.getUserPass())) + UserAccountToJSON(user);
          }
          break;
        case "patient":
          Patient patient = new PatientService().getByUserPass(up.getId());
          if (patient != null) {
            json = PatientToJSON(patient);
          }
          break;
        case "nurse":
          Nurse nurse = new NurseService().getByUserPass(up.getId());
          if (nurse != null) {
            json = NurseToJSON(nurse);
          }
          break;
        case "doctor":

          Doctor doctor = new DoctorService().getByUserPass(up.getId());
          if (doctor != null) {
            json = DoctorToJSON(doctor);
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
