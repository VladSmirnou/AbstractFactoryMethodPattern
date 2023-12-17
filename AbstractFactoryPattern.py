from abc import ABC, abstractmethod


class OffiseSuppliesFactory(ABC):

    # Some generic business logic here

    # factory method per every distinct product
    @abstractmethod
    def make_pen(self) -> 'Pen': ...

    @abstractmethod
    def make_pencil(self) -> 'Pencil': ...

# (interface|abstract class) per every distinct product
class Pen(ABC): ...


class Pencil(ABC): ...


class BallpointPen(Pen):
    def __str__(self) -> str:
        return 'BallpointPen'


class FeatherPen(Pen):
    def __str__(self) -> str:
        return 'FeatherPen'


class GraphitePencil(Pencil):
    __factory: str

    def __init__(self, factory: str) -> None:
        self.__factory = factory

    def __str__(self) -> str:
        return f'Pen from factory {self.__factory}'


class ManufacturerOne(OffiseSuppliesFactory):
    def make_pen(self) -> 'Pen':
        return BallpointPen()

    def make_pencil(self) -> 'Pencil':
        return GraphitePencil('ManufacturerOne')


class ManufacturerTwo(OffiseSuppliesFactory):
    def make_pen(self) -> 'Pen':
        return FeatherPen()

    def make_pencil(self) -> 'Pencil':
        return GraphitePencil('ManufacturerTwo')


def main() -> None:
    manufacturerOne: OffiseSuppliesFactory = ManufacturerOne()
    one_pen: Pen = manufacturerOne.make_pen()
    print(one_pen)
    one_pencil: Pencil = manufacturerOne.make_pencil()
    print(one_pencil)

    manufacturerTwo: OffiseSuppliesFactory = ManufacturerTwo()
    two_pen: Pen = manufacturerTwo.make_pen()
    print(two_pen)
    two_pencil: Pencil = manufacturerTwo.make_pencil()
    print(two_pencil)


main()
