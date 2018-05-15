import java.util.*;
import java.io.*;

/**
 * Write a description of class MainController here.
 * 
 * @author Jyhwoei Yang 
 * @version 16/05/2018
 */
public class MainController
{    
    // instance variables
    private ArrayList<User> userList;
    private ArrayList<Ticket> ticketList;
    private ArrayList<MovieSession> bookedTicketList;
    private ArrayList<MovieSession> availableTicketList;
    private ArrayList<MovieSession> movieSessionList;
    private ArrayList<MovieTicket> movieTicketList;
    
    /** Default Constructor of Class MovieDatabase
     * 
     */
    public MainController()
    {
        //initialise the variables
        userList = new ArrayList<User>();
        ticketList = new ArrayList<Ticket>();
        bookedTicketList = new ArrayList<MovieSession>();
        availableTicketList = new ArrayList<MovieSession>();
        movieSessionList = new ArrayList<MovieSession>();
        movieTicketList = new ArrayList<MovieTicket>();
    }
    
    /** Constructor of Class MovieDatabase
     * 
     */
    public MainController(ArrayList<User> userList, ArrayList<Ticket> ticketList, ArrayList<MovieSession> bookedTicketList, ArrayList<MovieSession> availableTicketList, ArrayList<MovieSession> movieSessionList, ArrayList<MovieTicket> movieTicketList)
    {
        //initialise the variables
        this.userList = userList;
        this.ticketList = ticketList;
        this.bookedTicketList = bookedTicketList;
        this.availableTicketList = availableTicketList;
        this.movieSessionList = movieSessionList;
        this.movieTicketList = movieTicketList;
    }
    
    /**
     * A method to add availableTicket to the availableTicketList
     * 
     * @param MovieSession the MovieSession Object
     * @return 
     */
    public void addAvailableTicket(MovieSession newMovieSession)
    {
        availableTicketList.add(newMovieSession);
    } 
    
    /**
     * A method to add bookedTicket to the bookedTicketList
     * 
     * @param MovieSession the MovieSession Object
     * @return 
     */
    public void addBookedTicket(MovieSession newMovieSession)
    {
        bookedTicketList.add(newMovieSession);
    } 
  
    /**
     * A method to delete availableTicket from the list
     * 
     * @param
     * @return 
     */
    public void deleteAvailableTicket(int index)
    {        
        //remove()
        boolean isDeleted = false;
        
        availableTicketList.get(index).display(); 
        System.out.println(" are deleted from the available ticket list.");
        availableTicketList.remove(index);
        isDeleted = true;                
      
        if (! isDeleted)
        {
            System.out.println(" No matched tickets are deleted."); 
        }
    }

    /**
     * A method to delete bookedTicket from the list
     * 
     * @param
     * @return 
     */
    public void deleteBookedTicket(int index)
    {        
        //remove()
        boolean isDeleted = false;

        bookedTicketList.get(index).display();
        System.out.println(" are deleted from the available ticket list.");
        bookedTicketList.remove(index);
        isDeleted = true;                
      
        if (! isDeleted)
        {
            System.out.println(" No matched tickets are deleted."); 
        }
    }
   
    /**
     * A method to return the size of user list
     * 
     * @param
     * @return count number of Users
     */
    public int getNumbersOfUsers()
    {
        return userList.size();
    } 
    
    /**
     * A method to match user
     * 
     * @param ArrayList<User> userList, searchName, searchPassword
     * @return resultList
     */
    public ArrayList<User> matchUsernameAndPassword(ArrayList<User> userList, String searchUserName, String searchPassword) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<User> resultList = new ArrayList<User>();
        
        for (int i = 0 ; i < userList.size(); i++)
        {
            if(userList.get(i).getUserName().toLowerCase().equals(searchUserName))
            {
                if(userList.get(i).getPassword().toLowerCase().equals(searchPassword))
                    resultList.add(userList.get(i));           
            }
        }        
        return resultList;
    }
    
    /**
     * A method to search movie session by name
     * 
     * @param String searchName
     * @return 
     */
    public void searchByName(String searchName)
    {
        //Movie session by name   
        for(int i = 0; i < movieSessionList.size(); i++)
        {
            if(movieSessionList.get(i).getMovieTitle().equals(searchName))
                movieSessionList.get(i).displayMovieTitle();
        }
    }
    
     /**
     * A method to search movie session by cinema
     * 
     * @param String searchCinema
     * @return
     */
    public void searchByCinema(String searchCinema)
    {
        //Movie session by cinema   
        for(int i = 0; i < movieSessionList.size(); i++)
        {
            if(movieSessionList.get(i).getLocation().equals(searchCinema))
                movieSessionList.get(i).displayMovieTitle();
        }
    }
    
     /**
     * A method to search ticket by email
     * 
     * @param String searchEmail
     * @return
     */
    public void searchByEmail(String searchEmail)
    {
        //Bookings by email   
        for(int i = 0; i < movieTicketList.size(); i++)
        {
            if(movieTicketList.get(i).getBuyerEmail().equals(searchEmail))
                movieTicketList.get(i).display();
        }
    }
}   
    