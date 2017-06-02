package performance.charla.components.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

import java.util.concurrent.ThreadLocalRandom;

@WicketHomePage
public class CharlaHomePage extends WebPage {

    private Model<Integer> modelCount = Model.of(0);

    public CharlaHomePage() {
        final Label label = new Label("count", modelCount);
        label.setOutputMarkupId(true);
        add(label);

        final Form<Integer> taxiForm = new Form<>("charlaForm", modelCount);
        taxiForm.add(new AjaxSubmitLink("guardar") {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                modelCount.setObject(modelCount.getObject() + 1);

                if (modelCount.getObject() > 200) {
                    try {
                        Thread.sleep(15000);
                    } catch (final InterruptedException ignored) {
                    }
                }
                if (modelCount.getObject() > 50 && (modelCount.getObject() %
                        ThreadLocalRandom.current().nextInt(1, 6 + 1) != 0)) {
                    throw new RuntimeException("Soy programado malo");
                }
                target.add(label);
            }
        });
        add(taxiForm);
    }

}
