package controllers;

import models.Persona;

public class PersonaController {

    public void sortByDireccionCodigo(Persona[] personas){
        System.out.println("Ordenando Arreglo: ");
        int index = 0;
        for (int i = 0; i <personas.length-1; i++) {
            index = i;
            for (int j = i+1; j < personas.length-1; j++) {
            // if(personas[j].getCodigoDireccion() > personas[index].getCodigoDireccion()){
                if(personas[j].equalsByCodigoDireccion(personas[index])){
                    index = j;
                }
            }
            if (index != i ) {
                Persona temPersona = personas[index];
                personas[index] = personas[i];
                personas[i] = temPersona;

            }
        }
    }
    public Persona findPersonaByCodigo(int codigo, Persona[] personas){
        int bajo = 0;
        int alto = personas.length-1;

        while (bajo<=alto) {
            int centro = (alto + bajo)/2;
            if (personas[centro].equalsByCodigoDireccion(codigo)) {
                return personas[centro];
            }else if (personas[centro].getCodigoDireccion() > codigo) {
                alto= centro-1;
            }else{
                bajo = centro +1;
            }
            
        }
        return null;


    }
    
}
