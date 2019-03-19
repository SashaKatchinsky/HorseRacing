package by.epam.java.horse_racing.controller;

import by.epam.java.horse_racing.bean.*;
import by.epam.java.horse_racing.command.factory.ActionFactory;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.dao.*;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.BetService;
import by.epam.java.horse_racing.service.EventService;
import by.epam.java.horse_racing.util.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {
        "/start",
        "/main"
})
public class HorseRacingServlet extends HttpServlet {
    private static final Logger HORSERACINGSERVLETLOGGER = LogManager.getLogger(HorseRacingServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getRequestURI().equals("/start")) {
            String errorLoginPassMessage = req.getParameter("errorLoginPassMessage");
            String registrationError = req.getParameter("registrationError");
            String successRegistration = req.getParameter("successRegistration");
            if (errorLoginPassMessage != null && errorLoginPassMessage.equals("true")) {
                if (req.getSession().getAttribute("language").equals("ru")) {
                    req.setAttribute("errorLoginPassMessage", MessageManager.getInstance().getProperty("message.ru.loginerror"));
                } else {
                    req.setAttribute("errorLoginPassMessage", MessageManager.getInstance().getProperty("message.en.loginerror"));
                }
            }
            if (registrationError != null && registrationError.equals("true")) {
                if (req.getSession().getAttribute("language").equals("ru")) {
                    req.setAttribute("registrationError", MessageManager.getInstance().getProperty("message.en.userexists"));
                } else {
                    req.setAttribute("registrationError", MessageManager.getInstance().getProperty("message.en.userexists"));
                }
            }
            if (successRegistration != null && successRegistration.equals("true")) {
                if (req.getSession().getAttribute("language").equals("ru")) {
                    req.setAttribute("successRegistration", MessageManager.getInstance().getProperty("message.ru.successregistration"));
                } else {
                    req.setAttribute("successRegistration", MessageManager.getInstance().getProperty("message.en.successregistration"));
                }
            }
        }
        if (req.getRequestURI().equals("/main")) {
            User user = null;
            List<Event> events = null;
            List<Event> playedEvents = null;
            List<Event> comingEvents = null;
            List<Bet> bets = null;
            List<Bet> allBets = null;
            List<Bet> playedBets = null;
            List<Bet> comingBets = null;
            List<Bet> allPlayedBets = null;
            List<Bet> allComingBets = null;
            List<User> users = null;
            List<Horse> horses = null;
            List<Rider> riders = null;
            try {
                user = UserDaoMySql.getInstance().getUserByLogin(((User)session.getAttribute("user")).getLogin());
                events = EventService.getInstance().sortEvents(EventDaoMySql.getInstance().getAllEvents());
                playedEvents = EventService.getInstance().getPlayedEvents(events);
                comingEvents = EventService.getInstance().getComingEvents(events);
                bets = BetService.getInstance().formBets(BetDaoMySql.getInstance().getAllUsersBets(((User)session.getAttribute("user")).getLogin()));
                playedBets = BetService.getInstance().getPlayedBets(bets);
                comingBets = BetService.getInstance().getComingBets(bets);
                allPlayedBets = BetService.getInstance().formBets(BetService.getInstance().getPlayedBets(BetDaoMySql.getInstance().getAllBets()));
                allComingBets = BetService.getInstance().formBets(BetService.getInstance().getComingBets(BetDaoMySql.getInstance().getAllBets()));
                allBets = BetService.getInstance().formBets(BetDaoMySql.getInstance().getAllBets());
                users = UserDaoMySql.getInstance().getAllUsers();
                horses = HorseDaoMySql.getInstance().getAllHorses();
                riders = RiderDaoMySql.getInstance().getAllRiders();
            } catch (DaoException e) {
                HORSERACINGSERVLETLOGGER.fatal("Can not fill lists" , e);
            }
            session.removeAttribute("user");
            session.setAttribute("user" , user);
            req.setAttribute("user" , user);
            req.setAttribute("events" , events);
            req.setAttribute("playedEvents" , playedEvents);
            req.setAttribute("comingEvents" , comingEvents);
            req.setAttribute("bets" , bets);
            req.setAttribute("allBets" , allBets);
            req.setAttribute("playedBets" , playedBets);
            req.setAttribute("comingBets" , comingBets);
            req.setAttribute("allPlayedBets" , allPlayedBets);
            req.setAttribute("allComingBets" , allComingBets);
            req.setAttribute("users" , users);
            req.setAttribute("horses" , horses);
            req.setAttribute("riders" , riders);
            req.setAttribute("language" , req.getSession().getAttribute("language"));
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp" + req.getRequestURI() + ".jsp");
        dispatcher.forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req , resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(req);
        if (command != null) {
            page = command.execute(req);
            if (page != null) {
                resp.sendRedirect(page);
            }
        }
    }
}
