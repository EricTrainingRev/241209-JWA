# Planetarium Resource Outline
This document outlines the structure of the Objects managed by the Planetarium Application

## User Resource
```java
    private int id;
    private String username;
    private String password;
```

## Planet Resource
```java
    private int planetId;
    private String planetName;
    private int ownerId;
    private byte[] imageData;
```

## Moon Resource
```java
    private int moonId;
    private String moonName;
    private int ownerId;
    private byte[] imageData;
```