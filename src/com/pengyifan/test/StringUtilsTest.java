package com.pengyifan.test;

import org.junit.Test;

import com.pengyifan.commons.lang.StringUtils;

public class StringUtilsTest {

  @Test
  public void test() {
    String paragraph = "For analysis of IRF-4T11 protein expressionT19, a "
        + "standard immunoblotting assay was performed as described previously "
        + "(29). Briefly, protein lysates were generated by incubating 1 x 106 "
        + "cells in 100 microl RIPA buffer (1% NP-40, 0.5% sodiumdesoxycholate, "
        + "0.1% SDS, 100 microg/ml phenylmethylsulfonyl fluoride, 10 microl/ml "
        + "protease-inhibitory-mix, 1 micromol/ml sodiumorthovanadate in "
        + "phosphate-buffered saline) for 30 min on ice. After centrifugation, "
        + "protein concentration of the supernatant was determined by "
        + "BCA-method (Pierce, Rockford, IL) as recommended. Protein lysates "
        + "(70-100 microg) were electrophoresed on polyacrylamide gels and "
        + "transferred to a PVDF-membrane (Immobilon P, 0.45 microm; Millipore,"
        + " Eschborn, Germany). Membranes were blocked with 2.5% blocking "
        + "reagent (Boehringer Mannheim, Germany) in TBST buffer (4.44 g/l "
        + "Tris-HCL, 2.65 g/l TrisOH, 8.07 g/l NaCl, 0.2 g/l KCl and 500 "
        + "microl/l Tween-20 in H2O) and subsequently incubated with primary "
        + "antibody as indicated and horseradish peroxidase-conjugated "
        + "secondary antibody, anti-mouse or anti-goat IgG (DAKO, Hamburg, "
        + "Germany), respectively. The membranes were then developed with an "
        + "ECL detection kit (Amersham Pharmacia Biotech, Freiburg, Germany). "
        + "The primary antibodies were goat anti-IRF-4/ICSAT (M-17) (Santa "
        + "Cruz Biotechnology, Santa Cruz, CA) and mouse anti-beta-actin "
        + "(AC-74) (Sigma).";
    System.out.println(StringUtils.hangIndent(paragraph, 3, 80, true));
    System.out.println(StringUtils.hangIndent(paragraph, 3, 80, false));
    System.out.println(StringUtils.hangIndent(paragraph, 0, 80, true));
    try {
      System.out.println(StringUtils.hangIndent(paragraph, -1, 80, true));
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    System.out.println(StringUtils.indent(paragraph, 3, 80, true));
    System.out.println(StringUtils.indent(paragraph, 3, 80, false));
  }

}
