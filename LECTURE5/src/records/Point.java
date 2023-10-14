package records;

final class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getters, setters, equals, hashcode, toString

    //User.class id firstName @Entity, @Table
    //users      id first_name

    //controller(postman, swagger)->service->repository->database
    //request, response->dto->entity
    //request->dto->entity->dto->response
}