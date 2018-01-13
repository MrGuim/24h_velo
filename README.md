# 24 Heures vélo : Java

## Git

Si la modification porte sur une _issue_, merci de bien vouloir respecter le format suivant 
```git
#1 - Description de la solution à l'issue n°1.
```
## Utilisation

### Code

Au niveau du code, l'utilisation sur macOS ou sur Windows est différente. 

Pour la version macOS, la classe _main_ s'écrit comme suit
```java
public static void main(final String[] args) {
  System.setProperty("apple.laf.useScreenMenuBar", "true");
  System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");
  EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
	    try {
		    Fenetre frame = new Fenetre();
		    frame.setVisible(true);
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
    }
  });
}
```
    
Tandis que pour la version Windows, la classe _main_ s'écrit comme suit
```java
public static void main(final String[] args) {
  EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
	    try {
		    Fenetre frame = new Fenetre();
		    frame.setVisible(true);
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
    }
  });
}
```
Normalement le fait de ne pas rajouter les lignes de code 
```java
System.setProperty("apple.laf.useScreenMenuBar", "true");
System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");
```
dans la version macOS ne fait pas planter le programme mais des erreurs qui ne seront pas _catch_ pourrait apparaître. C'est également le cas si vous laissez les lignes dans la version Windows. Mais par propreté du code, n'oubliez pas de les enveler/rajouter.

### Programme

## To Do 

Toutes les features qui ne doivent être faite sont listées dans cette section. Elles sont seulement basées sur les idées de l'auteur ainis que sur les discussions orales hors du GitHub. Les autres features qui ont été proposées sont disponible [ici](https://github.com/MrGuim/24h_velo/issues).
1. Ecrire le Readme.md avec notamment l'utilisation du programme.
2. Refonte complète de l'interface graphique.
3. Mettre un bouton Pause/Resume sur le chrono perso.
4. Commenter le programme
5. Optimiser les tâches.

## Licence

MIT License

Copyright (c) 2018 Guillaume

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
