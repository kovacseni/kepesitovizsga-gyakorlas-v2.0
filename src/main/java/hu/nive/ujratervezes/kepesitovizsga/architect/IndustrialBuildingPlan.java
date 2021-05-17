package hu.nive.ujratervezes.kepesitovizsga.architect;

public class IndustrialBuildingPlan implements Plan {

    private String projectName;
    private int areaOfOfficeBlock;
    private int stock;
    private int areaOfManufacturingHall;
    private PlanType type;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManufacturingHall) {
        this.projectName = projectName;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.stock = stock;
        this.areaOfManufacturingHall = areaOfManufacturingHall;
        this.type = PlanType.INDUSTRIAL;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return (stock * areaOfOfficeBlock + areaOfManufacturingHall);
    }

    @Override
    public PlanType getType() {
        return type;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManufacturingHall;
    }
}
