
package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import models.SabotBeanModel;

@RestController
@RequestMapping(value = "/api/sabots")
public class SabotController {

    private List<SabotBeanModel> sabots = new ArrayList<SabotBeanModel>();

    SabotController() {
        this.sabots = buildSabots();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SabotBeanModel> getSabots() {
        return this.sabots;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SabotBeanModel getSabot(@PathVariable("id") Long id) {
        return this.sabots.stream().filter(sabot -> sabot.getIdNumber() == id).findFirst().orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<SabotBeanModel> saveSabot(@RequestBody SabotBeanModel sabot) {
        int nextId = 0;
        if (this.sabots.size() != 0) {
            SabotBeanModel lastSabot = this.sabots.stream().skip(this.sabots.size() - 1).findFirst().orElse(null);
            nextId = lastSabot.getIdNumber() + 1;
        }
        sabot.setIdNumber(nextId);
        this.sabots.add(sabot);
        return this.sabots;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<SabotBeanModel> deleteSabot(@PathVariable int id) {
        for (Iterator<SabotBeanModel> iterator = this.sabots.iterator(); iterator.hasNext();) {
            SabotBeanModel sabot = iterator.next();
            int inId = sabot.getIdNumber();
            if (inId == id) {
                iterator.remove();
            }
        }
        return this.sabots;
    }

    private List<SabotBeanModel> buildSabots() {
        List<SabotBeanModel> sabots = new ArrayList<>();
        SabotBeanModel sabot1 = buildSabot(1, true , 58);
        SabotBeanModel sabot2 = buildSabot(2, false, 100);
        sabots.add(sabot1);
        sabots.add(sabot2);
        return sabots;
    }

    private SabotBeanModel buildSabot(int idNumber, boolean etatSabot, int etatBatterie) {
        SabotBeanModel sabot = new SabotBeanModel(idNumber, etatSabot, etatBatterie);
        return sabot;
    }


}