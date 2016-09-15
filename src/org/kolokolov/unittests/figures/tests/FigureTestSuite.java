package org.kolokolov.unittests.figures.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PointTest.class, 
    ParametrizedPointTest.class, 
    LineTest.class,
    TriangleTest.class})
public class FigureTestSuite {}
