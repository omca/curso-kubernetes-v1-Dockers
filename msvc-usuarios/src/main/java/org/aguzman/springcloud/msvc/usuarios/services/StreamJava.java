package org.aguzman.springcloud.msvc.usuarios.services;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamJava {

    public static void main(String[] args) {


        List<Nota> notas= new ArrayList<Nota>();
        notas.add(new Nota("matematicas",3));
        notas.add(new Nota("lengua",10));
        notas.add(new Nota("ingles",5));
        notas.add(new Nota("fisica",7));

        Optional<List<Nota>> optionalNota = Optional.of(notas);

        notas = notas.stream()
                .filter(x -> x.getValor() >= 9)
                .collect(Collectors.toList());
        notas.forEach(x -> System.out.println(x.getAsignatura()));

    }


}

class Nota {

    private String asignatura;
    private double valor;
    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Nota(String asignatura, double valor) {
        super();
        this.asignatura = asignatura;
        this.valor = valor;
    }
        }
