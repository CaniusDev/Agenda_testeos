package com.example.parcial_testeos;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegistrosActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<Registros> activityRule = new ActivityScenarioRule<>(Registros.class);

    @Test
    public void testGuardarContacto() {
        // Simulamos la entrada de datos en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.nombreEditText)).perform(ViewActions.typeText("Camila"));
        Espresso.onView(ViewMatchers.withId(R.id.edadEditText)).perform(ViewActions.typeText("7"));
        Espresso.onView(ViewMatchers.withId(R.id.ciudadEditText)).perform(ViewActions.typeText("Cali"));

        // Realizamos un click en el botón guardar
        Espresso.onView(ViewMatchers.withId(R.id.btn_guardar)).perform(ViewActions.click());

        // Verificamos que se muestre un Toast con el mensaje esperado
        Espresso.onView(ViewMatchers.withText("Contacto guardado exitosamente. El factorial de la edad es: 5040")).inRoot(new ToastMatcher())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
