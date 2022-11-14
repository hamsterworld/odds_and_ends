package enumusage.enum_study7;

public class Appconfig {

    //@Bean
    public EnumMapper enumMapper(){
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("FeeType", FeeType.class);

        return enumMapper;
    }



}
