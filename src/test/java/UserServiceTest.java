import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException {
// Création d'un nouvel utilisateur

            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
//exo3:
      // doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);
        // TODO : Configuration du comportement du mock, utiliser la
//directive « when » avec sa méthode « thenReturn »

       // doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
// ...
// TODO : Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
// TODO : Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
// ...
// TODO : Vérification de l'appel à l'API
        verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);
        //exo3:
        //verify(utilisateurApiMock, never()).creerUtilisateur(utilisateur);



}
    @Test
    public void testCreerUtilisateur_id() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock pour indiquer que la création d'utilisateur a réussi
       // when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        // Définition d'un ID fictif
        int idUtilisateur = 123;

        // Configuration du mock pour renvoyer l'ID
        when(utilisateurApiMock.getIdUtilisateur(utilisateur)).thenReturn(idUtilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        int idUtilisateurRetourne = utilisateurApiMock.getIdUtilisateur(utilisateur);
        assertEquals(idUtilisateur, idUtilisateurRetourne);
    }
    @Captor
    private ArgumentCaptor<Utilisateur> utilisateurCaptor;

    @Test
    public void testCreerUtilisateur_4() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock pour indiquer que la création d'utilisateur a réussi
       // when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);

        // Appel de la méthode à tester
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        // Capturer les arguments passés à la méthode creerUtilisateur
        verify(utilisateurApiMock).creerUtilisateur(utilisateurCaptor.capture());
        Utilisateur utilisateurCapture = utilisateurCaptor.getValue();

        // Vérification des arguments capturés
        assertEquals(utilisateur.getNom(), utilisateurCapture.getNom());
        assertEquals(utilisateur.getPrenom(), utilisateurCapture.getPrenom());
        assertEquals(utilisateur.getEmail(), utilisateurCapture.getEmail());
    }
}