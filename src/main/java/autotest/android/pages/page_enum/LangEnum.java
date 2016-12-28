package autotest.android.pages.page_enum;

/**
 * Created by zaborovsky on 27.12.2016.
 */
public interface LangEnum {
    public String getEngName();
    public String getRusName();
    default<T extends LangEnum> T[] getValues() {
        return null;
    }
}
