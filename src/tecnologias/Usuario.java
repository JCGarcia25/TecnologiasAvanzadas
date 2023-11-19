package tecnologias;

public class Usuario {

    private String nickname;
    private String contraseña;

    public Usuario(String nickname, String contraseña) {
        this.nickname = nickname;
        this.contraseña = contraseña;
    }


    public String getNickname() {
        return nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNickname(String usuario) {
        this.nickname = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

