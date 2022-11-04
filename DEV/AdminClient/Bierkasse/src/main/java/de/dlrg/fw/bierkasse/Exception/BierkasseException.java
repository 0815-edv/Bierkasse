/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.Exception;

/**
 *
 * @author flori
 */
public class BierkasseException extends Exception{

    public BierkasseException(String Model, String message) {
        super(Model +": "+message);
    }
    
}
