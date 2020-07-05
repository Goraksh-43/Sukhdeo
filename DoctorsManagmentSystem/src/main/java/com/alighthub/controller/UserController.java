package com.alighthub.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.dms.model.Doctor;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.service.EmployeeService;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



/*
 * 
 * @author Ravindra Sonawane
 * @page User Controller
 * @time 08/09/2019 - 9.05 PM
 * @purpose User Controller
 * 
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/emp")
//@XmlRootElement
public class UserController {
	
	
	private static String TITLE = null;
    public static final String PDF_EXTENSION = ".pdf";

    @Autowired 
    private JavaMailSender sender;
    
    File f=null;
    //static Admin ad=null;
	

	@Autowired
	private EmployeeService employeeservice;

	/*
	 * @Autowired private EmployeeService es;
	 */
	/*
	 * @PostMapping("/") public String openLog() { return "login";
	 * 
	 * }
	 */
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee e)
	{
		System.out.println("in add employee");
		//logger.info("This is add employee method");
		employeeservice.addEmployee(e);
		return "Data Added successfully";
		
	}
	
	@GetMapping("/{uname}/{pass}")
	public Employee getEmployee(@PathVariable String uname,@PathVariable String pass)
	{
		System.out.println("get employee called");
		Employee e=employeeservice.getEmployee(uname,pass);
		return e;
	}
	
	/*
	 * @GetMapping("/{empid}") public Employee getSingleEmployee(@PathVariable int
	 * empid) { Employee e=es.getSingleEmployee(empid); return e; }
	 */	
	@GetMapping("/edit/{id}")
	public Employee editEmployee(@PathVariable int id)
	{
		Employee e=employeeservice.editEmployee(id);
		return e;
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee e)
	{
		employeeservice.updateEmployee(e);
		return "Data updated successfully";
		
	}
	
	@DeleteMapping("/del/{id}")
	public String delete(@PathVariable int id)
	{
		employeeservice.delete(id);
		return "Data deleted successfully";
		
	}
	@GetMapping("/search/{employeeLname}")
	public List<Employee> search(@PathVariable String name)
	{
	   return null;
		
	}
    @GetMapping("/getlogin/{loginuname}/{loginpassword}")	
	public Login getData(@PathVariable String loginuname, @PathVariable String loginpassword ) {
		
		return employeeservice.getData(loginuname, loginpassword);
	}
   
    
   @GetMapping("/coun") 
   public long getCount()
   {
	return employeeservice.getCount();
	   
   }
   
   
	/*
	 * @GetMapping("/viewdoctor/{employeeId}") public List<Doctor>
	 * viewDoctorsUnderEmployee(@PathVariable int employeeId) { return
	 * employeeservice.viewDoctorsUnderEmployee(employeeId);
	 * 
	 * }
	 */   
	/*
	 * @GetMapping("/doctorcount") public long getDoctorCount() { return
	 * employeeservice.getDoctorCount();
	 * 
	 * }
	 */
   
   
   @GetMapping("/getdoctor/{empId}")
   public List<Doctor> getDoctorUnderEmployee(@PathVariable int empId)
   {
	   return employeeservice.getDoctorUnderEmployee(empId);
   }
   
   
   
   @GetMapping(value = "/getloguname/{loginuname}")
	public Employee findByLoginuname(@PathVariable String uname)
	{
		return employeeservice.findByLoginuname(uname);
	}
   
   
   
   //pdf generator when employee register
   
   
   
   public Employee citiesReport(String uname) throws MessagingException
  	{
  	  System.out.println(uname);
  	  
  	Employee employee=employeeservice.findByLoginuname(uname);
  	
  	 System.out.println("Email:-"+employee.getEmployeeEmail());
  	 System.out.println(employee.getEmployeeFname());
  		
  	    System.out.println("mail sending");
  		   TITLE=employee.getLogin().getLoginuname();
  		System.out.println("mail sending2");
  		Document document = new Document();
  	       try
  	       {
  	    	   System.out.println("In try block");
  	    	   f= new File("E:/"+TITLE + PDF_EXTENSION);
  	          PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
  	          document.open();
  	          
  	        //Set attributes here
  	          
  	          document.add(new Paragraph("Hello"+employee.getEmployeeFname()+" Your Data In PDF Form."));
  	               
  	          PdfPTable table1 = new PdfPTable(13); 
  	          table1.setWidthPercentage(100);
  	     	 // table1.setWidths(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
  	     	 
  	     	  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
  	     	  
  	     	  PdfPCell hcell;
  	     	  hcell = new PdfPCell(new Phrase("Id", headFont));
  	     	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER); 
  	     	  table1.addCell(hcell);
  	     	  
  	     	  hcell = new PdfPCell(new Phrase(" First Name", headFont));
  	     	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER); 
  	     	  table1.addCell(hcell);
  	     	  
  	     	  hcell = new PdfPCell(new Phrase("Last Name", headFont));
  	     	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	     	  table1.addCell(hcell);
  	     	  
  	     	  hcell = new PdfPCell(new Phrase("Email", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Gender", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	     	  
  	    	  hcell = new PdfPCell(new Phrase("Mobile No.", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Status", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Area", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("City", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("State", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Pincode", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Username", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Password", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	    	  hcell = new PdfPCell(new Phrase("Login Type", headFont));
  	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  	    	  table1.addCell(hcell);
  	    	  
  	     	  //for (City city : cities) {
  	     	  
  	     	  PdfPCell cell;
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getEmployeeId()));
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
  	     	  table1.addCell(cell);
  	     	  
  	     	  System.out.println(employee.getEmployeeId()+"100");
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getEmployeeFname())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	     	  
  	     	  System.out.println(employee.getEmployeeFname()+"200");
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getEmployeeLname())); 
  	    	  cell.setPaddingLeft(5);
  	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	    	  table1.addCell(cell);
  	    	  
  	    	  cell = new PdfPCell(new Phrase(employee.getEmployeeEmail())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getEmployeeGender())); 
  	    	  cell.setPaddingLeft(5);
  	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	    	  table1.addCell(cell);
  	    	  
  	    	  cell = new PdfPCell(new Phrase(employee.getEmployeeMobileNo())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getEmployeeStatus())); 
  	    	  cell.setPaddingLeft(5);
  	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	    	  table1.addCell(cell);
  	    	  
  	    	  cell = new PdfPCell(new Phrase(employee.getAddress().getAddressArea())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getAddress().getAddressCity())); 
  	    	  cell.setPaddingLeft(5);
  	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	    	  table1.addCell(cell);
  	     	  
  	    	  cell = new PdfPCell(new Phrase(employee.getAddress().getAddressState())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	     	  
  	     	  cell = new PdfPCell(new Phrase(employee.getAddress().getAddressPincode())); 
  	    	  cell.setPaddingLeft(5);
  	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	    	  table1.addCell(cell);
  	     	  
  	    	  
  	    	  cell = new PdfPCell(new Phrase(employee.getLogin().getLoginuname())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	    	  
  	     	  cell = new PdfPCell(new Phrase(employee.getLogin().getLoginpassword())); 
  	    	  cell.setPaddingLeft(5);
  	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	    	  table1.addCell(cell);
  	   	     
  	    	  cell = new PdfPCell(new Phrase(employee.getLogin().getLoginType())); 
  	     	  cell.setPaddingLeft(5);
  	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
  	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
  	     	  table1.addCell(cell);
  	    	  
  	     	  
  	     	  
  	     	  //}
  	     	  
  	     	  
  	     	 document.add(table1);
  	          
  	          
  	          
  	          
  	          document.close();
  	          writer.close();
  	       } catch (DocumentException e)
  	       {
  	          e.printStackTrace();
  	       } catch (FileNotFoundException e)
  	       {
  	          e.printStackTrace();
  	       }
  	     System.out.println("IN method");

  	       
  		return employee;
  		  		
  	}
  	
  	  // Mail Sending Code
  	@GetMapping("/getmap/{loginuname}")
  	 public String addTrainee(@PathVariable String loginuname) throws MessagingException
  	  {
  	  System.out.println(loginuname);
  	    System.out.println("Enter");
  	    
  	    //pdf generator method
  		Employee employee1= citiesReport(loginuname);
  		
  		
  	 // TODO Auto-generated method stub
  	  
  	  //SimpleMailMessage mail1=new SimpleMailMessage();
  	  
  	  MimeMessage msg=sender.createMimeMessage();
  	  
  	  MimeMessageHelper mail=new MimeMessageHelper(msg,true); 
  	  try 
  	  {
  		  System.out.println(employee1.getEmployeeEmail());
  		  String mail1=employee1.getEmployeeEmail();
  		  mail.setTo(mail1);
  	  
  	  mail.setFrom("gorakshbhoirkar43@gmail.com"); 
  	  mail.setSubject("SpringBoot Mail");
  	  mail.setText("Welcome to my company Alighthub Tech Consultancy");
  	  
  	  
  	  //ClassPathResource file=new ClassPathResource("E:\\pdfgenerator\\dms\\"+f); 
  	  System.out.println("file folder path");
  	  FileSystemResource file=new FileSystemResource(f);
  	  System.out.println("correct path");
  	  mail.addAttachment(file.getFilename(),file); }
  	  
  	 catch (MessagingException me) 
  	  {
  		 // * TODO: handle exception
  	 System.out.println(me.getMessage()); 
  	 }
  	  sender.send(msg); 
  	
  	  return "mail send successfully";
  	  }
}