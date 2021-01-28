package co.company.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Slipcontroller {

   @RequestMapping("/slip")
   public ResponseEntity slip(@RequestBody List<SlipVO> list) {
      if (list.size() < 1) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
      } else {
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("process", true);
         map.put("tcount", list.size());
         return ResponseEntity.status(HttpStatus.OK).body(map); //200
      }
   }

   @RequestMapping("/slip2")
   @ResponseBody
   public Map<String, Object> slip(@RequestBody List<SlipVO> list, HttpServletResponse response) {
      System.out.println(list);
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("process", true);
      map.put("tcount", list.size());
      map.put("pcount", list.size());
      return map;
   }
}