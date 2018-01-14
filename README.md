# 24 Heures vélo : Java

## Git

Pour ceux qui ne sont pas familier avec le git, cette petite section vous explique comment utiliser ce super logiciel. 
Il vous faut d'abord fork le repository (que nous appelerons dorénavant repo) afin que vous ayez une version copiée du repo officiel sur votre propre compte.
Ensuite, ouvrez votre invite de commande ou votre terminal dépendant de l'OS. Vous devrez vous placer dans le dossier dans lequel vous avez envie de copier le programme grâce à la commande 

	cd [répertoire]
	
Par exemple, sur macOS, si vous désirez copier le programme sur votre bureau il suffit de taper 

	cd /Desktop
	
Ensuite utiliser la commande 

	git clone https://github.com/[votre_pseudo]/24h_velo
	
Elle va cloner le repository sur votre ordinateur. Attention à bien vérifier que vous avez clone votre repo et que dans l'adresse URL, il y ait votre pseudo et pas _MrGuim_ Vous pouvez alors faire les modifications sur le programme. Ensuite pour upload vos modifications en ligne et qu'elles soient disponibles à tout le monde, vous devrez _commit_ vos modifications. Pour ce faire, tapez
	
	cd 24h_velo
Pour rentrer dans le repo et

	git add .
Pour ajouter toutes les modifications que vous avez fait. Ensuite,

	git commit -a -m "Description des modifications effectuées"
	git push
Bravo ! Vous avez upload les modifications sur votre repo mais maintenant, il faut les envoyer sur le repo officiel. Pour ça, il faut faire un pull request. Revenez à l'URL https://github.com/MrGuim/24h_velo et cliquer sur pull request. Créez en un nouveau et voilà le tour est joué. Une fois que vos modifications auront été acceptées, elles seront disponibles à tout le monde. 

ATTENTION ! Avant de commencer à coder, faites toujours un 

	git pull
	
dans le dossier où est le repo afin d'être sûr que vous avez la dernière version en date du code.

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
