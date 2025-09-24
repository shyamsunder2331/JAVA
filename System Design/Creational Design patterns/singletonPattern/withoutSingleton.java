class AppSetting{
    private static AppSetting instance;
    private String databaseUrl;
    private String name;
    private AppSetting(){
        databaseUrl="jdbc://loaclhost:102.23.32.21/jdbc";
        name="JDBC-17";
    }
    public static AppSetting getInstance(){
        if(instance==null){
        instance=new AppSetting();}
        return instance;
    }
    public String getName(){
        return this.name;
    }
}
public class withoutSingleton{
    public static void main(String[] args) {
        AppSetting app=AppSetting.getInstance();
        AppSetting ap=AppSetting.getInstance();
        System.out.println(app.getName());
        System.out.println(ap==app);
    }
}