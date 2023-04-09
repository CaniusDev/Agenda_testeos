package com.example.parcial_testeos;
import static org.hamcrest.MatcherAssert.assertThat;
import android.content.ComponentName;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MainActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLoginValido() {
        // Aqui se introduce el nombre y contraseña correctos
        Espresso.onView(ViewMatchers.withId(R.id.nombreEditText)).perform(ViewActions.typeText("canius"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText)).perform(ViewActions.typeText("1104"));
        Espresso.closeSoftKeyboard();

        // Acción de presionar el boton para pasar a la otra activity
        Espresso.onView(ViewMatchers.withId(R.id.btn_ingresar)).perform(ViewActions.click());

        // Verifica que efectivamente si se haya pasado a la otra acitivity
        ActivityScenario<Registros> scenario = ActivityScenario.launch(Registros.class);
        scenario.onActivity(activity -> assertThat(activity.getComponentName(), Matchers.equalTo(new ComponentName(activity, Registros.class))));
    }

    @Test
    public void testLoginFallido() {
        // Aqui se introduce el nombre y contraseña incorrectos
        Espresso.onView(ViewMatchers.withId(R.id.nombreEditText)).perform(ViewActions.typeText("Canius12351")); //poner usuario invalido
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText)).perform(ViewActions.typeText("1230195")); //poner pass invalida
        Espresso.closeSoftKeyboard();

        // Acción de presionar el boton para pasar a la otra activity
        Espresso.onView(ViewMatchers.withId(R.id.btn_ingresar)).perform(ViewActions.click());

        // Verifica que sale un mensaje de error ya que es invalido el usuario
        Espresso.onView(ViewMatchers.withText("Nombre de usuario o contraseña incorrectos")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
