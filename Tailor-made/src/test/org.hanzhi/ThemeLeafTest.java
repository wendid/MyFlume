import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
/**
 * Created by hanzhi on 15-3-26.
 */

public class ThemeLeafTest extends AbstractContextControllerTests  {
    @Test
    public void submitSucess() throws Exception
    {
        this.mockMvc.perform(
                post("/form")
                        .param("name", "Joe")
                        .param("age", "56")
                        .param("birthDate", "1941-12-16")
                        .param("phone", "(347) 888-1234")
                        .param("currency", "$123.33")
                        .param("percent", "89%")
                        .param("inquiry", "comment")
                        .param("inquiryDetails", "what is?")
                        .param("additionalInfo[mvc]", "true")
                        .param("_additionalInfo[mvc]", "on")
                        .param("additionalInfo[java]", "true")
                        .param("_additionalInfo[java]", "on")
                        .param("subscribeNewsletter", "false"))
                .andDo(print())
                .andExpect(status().isMovedTemporarily())
                .andExpect(redirectedUrl("/form"))
                .andExpect(flash().attribute("message",
                        "Form submitted successfully.  Bound properties name='Joe', age=56, " +
                                "birthDate=Tue Dec 16 00:00:00 " + timezone + " 1941, phone='(347) 888-1234', " +
                                "currency=123.33, percent=0.89, inquiry=comment, inquiryDetails='what is?'," +
                                " subscribeNewsletter=false, additionalInfo={java=true, mvc=true}"));
    }
}
