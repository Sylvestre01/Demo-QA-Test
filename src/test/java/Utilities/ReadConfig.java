package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    // Properties Class
    Properties pro;
    private final String filePath= "src/test/resources/Properties/Config.properties";



    // Constructor
    public ReadConfig() {
        // Creating File object
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            pro = new Properties();
            try {
                pro.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + filePath);
        }
    }
    // Methods to read data from config.properties

    public String getDriverPath(){
        String driverPath = pro.getProperty("chromePath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getApplicationURL() {
        String url=pro.getProperty("baseUrl");
        return url;
    }

    public String getbrowser() {
        String browser = pro.getProperty("browser");
        return browser;
    }

    public String getFirstname() {
        String firstName=pro.getProperty("firstName");
        return firstName;
    }

    public String getLastname() {
        String lastName = pro.getProperty("lastName");
        return lastName;
    }

    public String getUsername() {
        String username =pro.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getFullName() {
        String fullName = pro.getProperty("fullName");
        return fullName;
    }

    public String getEmailAddress() {
        String emailAddress = pro.getProperty("emailAddress");
        return emailAddress;
    }

    public String getCurrentAddress() {
        String currentAddress = pro.getProperty("currentAddress");
        return currentAddress;
    }

    public String getPermanentAddress() {
        String permAddress = pro.getProperty("permAddress");
        return permAddress;
    }

    public String getAge() {
        String age = pro.getProperty("age");
        return age;
    }

    public String getSalary() {
        String salary = pro.getProperty("salary");
        return salary;
    }

    public String getDepartment() {
        String department = pro.getProperty("department");
        return department;
    }

    public String getUploadFilePath() {
        String filePath = pro.getProperty("filePath");
        return filePath;
    }

    public String getFileName() {
        String fileName = pro.getProperty("fileName");
        return fileName;
    }

    public String getDownloadPath() {
        String downloadPath = pro.getProperty("downloadPath");
        return downloadPath;
    }
}
