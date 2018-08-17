package com.hd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hd.service.DownVideoService;
import java.util.Map;

@RestController
@RequestMapping("/down/video")
public class EmpBasicController {
    @Autowired
    DownVideoService downVideoService;
   

    @RequestMapping(value = "/basicdata", method = RequestMethod.GET)
    public Map<String, Object> getAllNations() {
    	return null;
    }
    
    

   /* @RequestMapping("/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", empService.getMaxWorkID() + 1);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public RespBean addEmp(Employee employee) {
        if (empService.addEmp(employee) == 1) {
            List<Position> allPos = positionService.getAllPos();
            for (Position allPo : allPos) {
                if (allPo.getId() == employee.getPosId()) {
                    employee.setPosName(allPo.getName());
                }
            }
            executorService.execute(new EmailRunnable(employee));
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public RespBean updateEmp(Employee employee) {
        if (empService.updateEmp(employee) == 1) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteEmpById(@PathVariable String ids) {
        if (empService.deleteEmpById(ids)) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }*/
}
