package co.falabella.com.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ListaResultadosUI {
    public static final Target LST_PRODUCTOS1 = Target.the("Lista de resultados de productos")
            .locatedBy("//b[@class='jsx-1576191951 title2 primary  jsx-2889528833 bold       pod-subTitle subTitle-rebrand' and not(@is-empty)]");

    public static final Target LST_PRODUCTOS2 = Target.the("Lista de resultados de productos en cuadricula")
            .locatedBy("//b[@class=\"jsx-1833870204 copy2 primary  jsx-2889528833 normal       pod-subTitle subTitle-rebrand\"]");

}
