/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

/**
 *
 * @author shibo
 */
public class Credit {

    private String part1;
    private String part2;
    private String part3;

    public String getPart1() {
        return part1;
    }

    public Credit(String part1, String part2, String part3) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public String toString() {
        return    part1 + "-" + part2 + "-" + part3 ;
    }

    
}
