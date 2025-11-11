package todoLis;

public class toDoList {
    private  String status;
    private String description;
    private String ddlTime;
    private int index;

    public toDoList() {
    }

    public toDoList(String Status, String description, String ddlTime) {
        this.status = status;
        this.description = description;
        this.ddlTime = ddlTime;
    }

    public toDoList(String status, String description, String ddlTime, int index) {
        this.status = status;
        this.description = description;
        this.ddlTime = ddlTime;
        this.index = index;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return ddlTime
     */
    public String getDdlTime() {
        return ddlTime;
    }

    /**
     * 设置
     * @param ddlTime
     */
    public void setDdlTime(String ddlTime) {
        this.ddlTime = ddlTime;
    }

    /**
     * 获取
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * 设置
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }


    public String toString() {
        return "序号" + index + " | " + "状态 : " + status + " | 描述 : " + description + " | 截止时间 : " + ddlTime;
    }
}
