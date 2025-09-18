package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    @Test
    public void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
    public void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
    }

    @Test
    public void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(4), Noeud(1))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals(listeATester.toString(),"ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(2))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimeTousListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2))");
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    public void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))");
    }

    @Test
    public void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3))");
    }

    @Test
    public void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))");
    }

    @Test
    public void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }

    @Test
    public void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }

    @Test
    public void supprimePremierElementAbsent() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);

        // On cherche à supprimer un élément qui n'existe pas
        listeATester.supprimePremier(99);

        // Rien ne doit avoir changé
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void modifiePremierEnTete() {
        // crée la liste 3 -> 2 -> 1 (ajout place en tete)
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);

        // modifier l'élément en tête (3 -> 42)
        listeATester.modifiePremier(3, 42);

        // vérifications : la tete a bien été modifiée et toString correct
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(42), Noeud(2), Noeud(1))");
        assertEquals(42, listeATester.tete.getElement());
    }

    @Test
    public void modifiePremierElementAbsent() {
        // crée la liste 3 -> 2 -> 1
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);

        // tenter de modifier un élément qui n'existe pas : rien ne doit changer
        listeATester.modifiePremier(99, 42);

        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(2), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void modifiePremierListeVide() {
        // sur liste vide, appeler modifiePremier ne doit rien casser
        listeATester.modifiePremier(1, 10);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void echangerMemeNoeudNeChangeRien() {
        // liste = 3 -> 2 -> 1
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);

        // on récupère un noeud quelconque (ici le noeud contenant 2)
        Noeud n = findNode(2);
        String before = listeATester.toString();

        // appel avec les mêmes références : doit retourner immédiatement (branche r1==r2)
        listeATester.echanger(n, n);

        // rien ne doit avoir changé
        assertEquals(listeATester.toString(), before);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void echangerQuandR2EstTete_R1NonAdjacent() {
        // construit 4 -> 3 -> 2 -> 1
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);

        Noeud r1 = findNode(2);       // noeud "2" (non-adjacent à la tête)
        Noeud r2 = listeATester.tete; // noeud "4" (la tête)

        assertNotNull(r1);
        assertNotNull(r2);
        assertNotSame(r1, r2);

        listeATester.echanger(r1, r2);

        // résultat attendu après échange : 2 -> 3 -> 4 -> 1
        assertEquals("ListeSimple(Noeud(2), Noeud(3), Noeud(4), Noeud(1))", listeATester.toString());
    }

    @Test
    public void echangerQuandR2EstTete_R1Adjacent() {
        // construit 4 -> 3 -> 2 -> 1
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);

        Noeud r1 = listeATester.tete.getSuivant(); // noeud "3" (adjacent à la tête)
        Noeud r2 = listeATester.tete;               // noeud "4" (la tête)

        listeATester.echanger(r1, r2);

        // résultat attendu après échange : 3 -> 4 -> 2 -> 1
        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    public void echangerQuandR2EstTete_R1Dernier() {
        // construit 4 -> 3 -> 2 -> 1
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);

        Noeud r1 = findNode(1);       // noeud "1" (dernier)
        Noeud r2 = listeATester.tete; // noeud "4" (la tête)

        listeATester.echanger(r1, r2);

        // résultat attendu après échange : 1 -> 3 -> 2 -> 4
        assertEquals("ListeSimple(Noeud(1), Noeud(3), Noeud(2), Noeud(4))", listeATester.toString());
    }

    private Noeud findNode(Object element) {
        Noeud cur = listeATester.tete;
        while (cur != null) {
            if (element == null ? cur.getElement() == null : element.equals(cur.getElement())) {
                return cur;
            }
            cur = cur.getSuivant();
        }
        return null;
    }



}