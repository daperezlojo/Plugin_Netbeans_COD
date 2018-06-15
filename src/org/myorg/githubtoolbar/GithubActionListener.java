/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.githubtoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.myorg.githubtoolbar.GithubActionListener"
)
@ActionRegistration(
        iconBase = "org/myorg/githubtoolbar/githubicon.png",
        displayName = "#CTL_GithubActionListener"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_GithubActionListener=GitHub")

/**
 * Clase en la que se creará el repositorio de Github.
 */
public final class GithubActionListener implements ActionListener {

    /**
     * Método que, tras hacer click en el botón (evento) pide un nombre para
     * crear el repositorio en Github.
     * @param e Evento de hacer click en el boton.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Se piden las credenciales para poder crear el repositorio:
        String user = JOptionPane.showInputDialog("Nombre del usuario:");
        String pass = JOptionPane.showInputDialog("Contraseña:");
        String nombre = JOptionPane.showInputDialog("Nombre para el repositorio:");
        try {
            GitHub github = GitHub.connectUsingPassword(user, pass);
            GHCreateRepositoryBuilder builder;
            builder = github.createRepository(nombre);
            builder.create();
        } catch (IOException ex) {
            System.out.println("Mensaje de error:" + ex);
        }
    }
}
