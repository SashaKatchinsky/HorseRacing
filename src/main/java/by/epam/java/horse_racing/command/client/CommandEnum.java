package by.epam.java.horse_racing.command.client;

import by.epam.java.horse_racing.command.*;
import by.epam.java.horse_racing.command.impl.ActionCommand;

/**
 * The enum Command enum.
 */
public enum CommandEnum {
    /**
     * The Login.
     */
    LOGIN {
        {
            this.command = new LoginUserCommand();
        }
    },
    /**
     * The Logout.
     */
    LOGOUT {
        {
            this.command = new LogoutUserCommand();
        }
    },
    /**
     * The Registration.
     */
    REGISTRATION {
        {
            this.command = new RegisterUserCommand();
        }
    },
    /**
     * The Bet.
     */
    BET {
        {
            this.command = new DoBetCommand();
        }
    },
    /**
     * The Deletebet.
     */
    DELETEBET {
        {
            this.command = new DeleteBetCommand();
        }
    },
    /**
     * The Updateuser.
     */
    UPDATEUSER {
        {
            this.command = new UpdateUserCommand();
        }
    },
    /**
     * The Deleteuser.
     */
    DELETEUSER {
        {
            this.command = new DeleteUserCommand();
        }
    },
    /**
     * The Addrider.
     */
    ADDRIDER {
        {
            this.command = new AddRiderCommand();
        }
    },
    /**
     * The Updaterider.
     */
    UPDATERIDER {
        {
            this.command = new UpdateRiderCommand();
        }
    },
    /**
     * The Deleterider.
     */
    DELETERIDER {
        {
            this.command = new DeleteRiderCommand();
        }
    },
    /**
     * The Addhorse.
     */
    ADDHORSE {
        {
            this.command = new AddHorseCommand();
        }
    },
    /**
     * The Update horse.
     */
    UPDATEHORSE {
        {
            this.command = new UpdateHorseCommand();
        }
    },
    /**
     * The Delete horse.
     */
    DELETEHORSE {
        {
            this.command = new DeleteHorseCommand();
        }
    },
    /**
     * The Add ivent.
     */
    ADDIVENT {
        {
            this.command = new AddEventCommand();
        }
    },
    /**
     * The Update event.
     */
    UPDATEIVENT {
        {
            this.command = new UpdateEventCommand();
        }
    },
    /**
     * The Delete event.
     */
    DELETEEVENT {
        {
            this.command = new DeleteEventCommand();
        }
    },
    SETRUSSIANLANGUAGE {
        {
            this.command = new SetRussianLanguageCommand();
        }
    },
    SETENGLISHLANGUAGE {
        {
            this.command = new SetEnglishLanguageCommand();
        }
    };
    /**
     * The Command.
     */
    ActionCommand command;

    /**
     * Gets current command.
     *
     * @return the current command
     */
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
