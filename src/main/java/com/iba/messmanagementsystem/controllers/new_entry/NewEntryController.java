package com.iba.messmanagementsystem.controllers.new_entry;

import com.iba.messmanagementsystem.models.*;
import com.iba.messmanagementsystem.repositories.*;
import com.iba.messmanagementsystem.services.CookHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NewEntryController {
//    private static Logger log = LoggerFactory.getLogger(NewEntryController.class);
//    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

//    @Autowired
//    private StudentServiceImpl studentService;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private On_OFFRepository on_offRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private CookHelperService cookHelperService;

    @Autowired
    private CookHelperRepository cookHelperRepository;

    @Autowired
    private MessTimingRepository messTimingRepository;

    @Autowired
    private UnitsRepository unitsRepository;

    @Autowired
    private MessManagerRepository messManagerRepository;

    @Autowired
    private DailyUnitPriceRepository dailyUnitPriceRepository;

    @Autowired
    private MessMenueRepository messMenueRepository;

    @PostConstruct
    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for (Students student : studentsRepository.findAll())
            students.add(student.getId() + "-" + student.getStudentName());
        return students;
    }

    @GetMapping("/addContactUs")
    public String addContactUs(Model model) {
        return "forms/new_entry/new_contact_us";
    }

    @GetMapping("/addUnitDetails")
    public String addUnitDetails(Model model) {
        return "forms/new_entry/new_unit_details";
    }

    //-------------Cook and Helpers Add Logic-----------------------
    @RequestMapping("/addCookHelpers")
    public String addCookHelpers(Model model) throws Exception {
        if (!(cookHelperRepository.getTotal() >= 2)) {
            Cook_Helpers cook_helpers = new Cook_Helpers();
            model.addAttribute("cook_helpers", cook_helpers);
            return "forms/new_entry/new_cook_helper";
        }
        model.addAttribute("cookExists", "delete or update cook first");
        return "redirect:/";
    }

    @PostMapping("/saveCookHelpers")
    public String saveCookHelpers(@ModelAttribute("cook_helpers") Cook_Helpers cook_helpers, Model model) {
        try {
            cookHelperService.saveDetails(cook_helpers);
            return "redirect:/addCookHelpers";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "phone Already Exist");
            return "forms/new_entry/new_cook_helper";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": may be phone is going to be repeat");
        }
        return "forms/new_entry/new_cook_helper";
    }

    //___________________________Mess menu new entry logic
    @GetMapping("/addMessMenue")
    public String addMessMenue(Model model) throws Exception {
        if (!(messMenueRepository.getTotal() >= 3)) {
            MessMenue messMenu = new MessMenue();
            model.addAttribute("messMenu", messMenu);
            return "forms/new_entry/new_mess_menu";
        }
        return "redirect:/";
    }

    @PostMapping("/saveMessMenu")
    public String saveMessMenu(@ModelAttribute("messMenu") MessMenue messMenue, Model model) {
        try {
            messMenueRepository.save(messMenue);
            return "redirect:/addMessMenue";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "some info already Exist");
            return "forms/new_entry/new_mess_menu";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": something went wrong");
        }
        return "forms/new_entry/new_mess_menu";
    }
    //___________________________On off status new entry logic

    @GetMapping("/addOnOffStatus")
    public String addOnOffStatus(Model model) throws Exception {
        On_OFF onOff = new On_OFF();

        model.addAttribute("students", getAllStudents());
        model.addAttribute("onOff", onOff);
        return "forms/new_entry/new_on_off";
    }

    @PostMapping("/saveOnOffStatus")
    public String saveOnOffStatus(@ModelAttribute("onOff") On_OFF onOff, Model model) {
        try {
            on_offRepository.save(onOff);
            return "redirect:/addOnOffStatus";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "some info already Exist");
            return "forms/new_entry/new_on_off";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": something went wrong");
        }
        return "forms/new_entry/new_on_off";
    }

    //___________________________Payments new entry logic
    @GetMapping("/addPayments")
    public String addPayments(Model model) {
        Payments payment = new Payments();
        model.addAttribute("students", getAllStudents());
        model.addAttribute("payment", payment);
        return "forms/new_entry/new_payments";
    }

    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment") Payments payment, Model model) {
        try {
            paymentsRepository.save(payment);
            return "redirect:/addPayments";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "some info already e.g phone or mail etc its unique Exist");
            return "forms/new_entry/new_payments";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": something went wrong");
        }
        return "forms/new_entry/new_payments";
    }

    //___________________________mess timings new entry logic
    @GetMapping("/addMessTimings")
    public String addMessTimings(Model model) {
        MessTimings messTimings = new MessTimings();
        model.addAttribute("messTiming", messTimings);
        return "forms/new_entry/new_mess_timings";
    }

    @PostMapping("/saveMessTimings")
    public String saveMessTimings(@ModelAttribute("messTiming") MessTimings messTiming, Model model) {
        try {
            messTimingRepository.save(messTiming);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", e.getMessage());
            return "forms/new_entry/new_mess_timings";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": something went wrong");
        }
        return "forms/new_entry/new_mess_timings";
    }

    //________________________Add new Student logic

//    @PostMapping("/saveStudent")
//    public @ResponseBody
//    ResponseEntity<?> createStudent(@Validated Students students,
//                                     @RequestParam("name") final String name,
//                                     final @RequestParam("file") MultipartFile file) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            if (students == null) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//            String fileName = file.getOriginalFilename();
//            String filePath = Paths.get(uploadDirectory, fileName).toString();
//            String fileType = file.getContentType();
//            long size = file.getSize();
//            String fileSize = String.valueOf(size);
//            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
//
//            log.info("Name: " + name);
//            log.info("FileName: " + file.getOriginalFilename());
//            log.info("FileType: " + file.getContentType());
//            log.info("FileSize: " + file.getSize());
//
//            // Save the file locally
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//            stream.write(file.getBytes());
//            stream.close();
//
//            students.setStudentName(name);
//            students.setFileName(fileName);
//            students.setFilePath(filePath);
//            students.setFileType(fileType);
//            students.setFileSize(fileSize);
//            students.setDate(currentTimestamp);
//
//            boolean status = studentService.saveStudent(students);
//            if (status) {
//                log.info("Student Created");
//                headers.add("Student Saved With Image - ", fileName);
//                return new ResponseEntity<>("Student Saved With File - " + fileName, headers, HttpStatus.OK);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("Exception: " + e);
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        Students student = new Students();
        model.addAttribute("student", student);
        return "forms/new_entry/new_students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Students student, Model model) {
        try {
            studentsRepository.save(student);
            return "redirect:/addStudent";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", e.getMessage());
            return "forms/new_entry/new_students";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": something went wrong");
        }
        return "forms/new_entry/new_students";
    }

    //________________________Add new Mess Manager logic

    @GetMapping("/addMessManager")
    public String addMessManager(Model model) {
        MessManager messManager = new MessManager();
        model.addAttribute("messManager", messManager);
        return "forms/new_entry/new_mess_manager";
    }

    @PostMapping("/saveMessManager")
    public String saveMessManager(@ModelAttribute("messManager") MessManager messManager, Model model) {
        try {
            messManagerRepository.save(messManager);
            return "redirect:/addMessManager";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", e.getMessage());
            return "forms/new_entry/new_mess_manager";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + ": something went wrong");
        }
        return "forms/new_entry/new_mess_manager";
    }


}
