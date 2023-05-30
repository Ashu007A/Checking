/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class NewClass extends JFrame {
    private final int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public NewClass() {
        setTitle("Maze Solver");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);
        
        System.out.println(path);
    }
    
    @Override
    public void paint(Graphics g) {
        g.translate(50, 50);
        
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                
                switch(maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                
                g.setColor(color);
                g.fill3DRect(30*j, 30*i, 30, 30, true);
                g.setColor(Color.RED);
                g.draw3DRect(30*j, 30*i, 30, 30, true);
            }
        }
        
        for (int i = 0; i < path.size(); i += 2) {
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            
            System.out.println("X - " + pathx);
            System.out.println("Y - " + pathy);
            
            g.setColor(Color.GREEN);
            g.fill3DRect(30*pathx, 30*pathy, 20, 20, true);
        }
    }
    
    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
