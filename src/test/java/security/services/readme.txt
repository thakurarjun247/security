Refer:
    https://www.youtube.com/watch?v=d2KwvXQgQx4

Note:
userserviceimpl will be the SAT(sytem under test) as opposed to the todobusinessimpl in the youutbe video
userrepository we will stubbed/mocked as opposed to the todoservice in the youtube video

We will follow these steps:
1. create a stub manually and use it. Implement a custom stub of the UserRepository to return predefined data for testing.
2. create a mock using mock() method and use it.Use Mockito's mock() to mock UserRepository and define its behavior using when() and thenReturn() to return the mock data.
3. use annotations for a more refined approach. Use annotations like @Mock and @InjectMocks for cleaner, more maintainable test code without explicitly calling mock() and when(). This will also help with dependency injection automatically.
