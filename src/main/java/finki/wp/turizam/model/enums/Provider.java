package finki.wp.turizam.model.enums;

/**
 * Created by Aleksandar on 25.06.2017.
 */
public enum Provider {
  LOCAL {
    @Override
    public String getLoginUrl() {
      return "/login";
    }
  },
  GITHUB {
    @Override
    public String getLoginUrl() {
      return "/login/github";
    }
  },
  GOOGLE {
    @Override
    public String getLoginUrl() {
      return "/login/google";
    }
  },
  FACEBOOK {
    @Override
    public String getLoginUrl() {
      return "/login/facebook";
    }
  };

  public String getLoginUrl() {
    return null;
  }
}
