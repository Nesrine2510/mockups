package org.example;

public class UserService {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public Utilisateur creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
        return utilisateur;
    }
}
