package player;

abstract class mutlimediaElement {
    protected String title;

    public mutlimediaElement(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
