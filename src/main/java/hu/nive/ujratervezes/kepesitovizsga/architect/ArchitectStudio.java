package hu.nive.ujratervezes.kepesitovizsga.architect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArchitectStudio {

    private Map<String, Plan> plans = new HashMap<>();

    public Map<String, Plan> getPlans() {
        return new HashMap<>(plans);
    }

    public void addPlan(String workingTitle, Plan plan) {
        if (isEmpty(workingTitle) || plan == null) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        plans.put(workingTitle, plan);
    }

    public Plan getPlanWithMaxSquareMeter() {
        int max = 0;
        Plan planWithMax = null;
        for (Plan p : plans.values()) {
            if (p.calculateSquareMeter() > max) {
                max = p.calculateSquareMeter();
                planWithMax = p;
            }
        }
        return planWithMax;
    }

    public Plan getPlanByWorkingTitle(String workingTitle) {
        if (isEmpty(workingTitle)) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        if (plans.containsKey(workingTitle)) {
            return plans.get(workingTitle);
        }
        throw new IllegalArgumentException("No such project.");
    }

    public Plan getPlanByProjectName(String projectName) {
        if (isEmpty(projectName)) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        for (Plan p : plans.values()) {
            if (p.getProjectName().equals(projectName)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No such project.");
    }

    public List<Plan> getSmallerPlans(int squareMeter) {
        List<Plan> smallerPlans = new ArrayList<>();
        for (Plan p : plans.values()) {
            if (p.calculateSquareMeter() < squareMeter) {
                smallerPlans.add(p);
            }
        }
        return smallerPlans;
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        List<Plan> result = new ArrayList<>();
        for (Plan p : plans.values()) {
            if (p.getType() == type) {
                result.add(p);
            }
        }
        return result;
    }

    private boolean isEmpty(String str) {
       return (str == null || str.isBlank());
    }
}
