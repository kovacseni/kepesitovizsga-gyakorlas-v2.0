package hu.nive.ujratervezes.kepesitovizsga.architect;

public class PublicBuildingPlan implements Plan {

    private String projectName;
    private int stock;
    private int area;
    private PlanType type;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
        this.type = PlanType.PUBLIC;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return stock * area;
    }

    @Override
    public PlanType getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
